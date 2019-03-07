package br.com.bmt.reports.converters;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import br.com.bmt.reports.controllers.dto.BaseRestDTO;
import br.com.bmt.reports.persistence.dto.BaseDbDTO;

public class DtoConverterFactory {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DtoConverterFactory.class); 
	
	public static final String BASE_PACKAGE_REST = "br.com.bmt.reports.converters.rest";
	public static final String BASE_PACKAGE_DB = "br.com.bmt.reports.converters.db";
	
	private static final int DB_SUFFIX_LENGTH = 5;
	private static final int REST_SUFFIX_LENGTH = 7;
	
	@SuppressWarnings({ "rawtypes" })
	public static <T extends BaseDbDTO> Optional<DbDtoConverter> createDbDtoConverter(Class<T> dtoType) {
		ClassPathScanningCandidateComponentProvider scanner = prepareScanner(DbConverter.class);
		
		for (BeanDefinition beanDef : scanner.findCandidateComponents(BASE_PACKAGE_DB)) {
			try {
				Class<?> converterClass = Class.forName(beanDef.getBeanClassName());
				DbConverter annotation = converterClass.getAnnotation(DbConverter.class);
				String dtoNameWithoutSuffix = dtoType.getSimpleName().
						substring(0, dtoType.getSimpleName().length() - DB_SUFFIX_LENGTH);
				
				if (annotation.dto().toLowerCase().contentEquals((dtoNameWithoutSuffix.toLowerCase()))) {
					return (Optional<DbDtoConverter>) 
							Optional.of((DbDtoConverter) Class.forName(beanDef.getBeanClassName()).newInstance());
				}
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				LOGGER.error("Problemas ao criar o conversor. Mensagem = {}", e.getMessage());
			}
		}
		return Optional.empty();
	}
	
	@SuppressWarnings({ "rawtypes" })
	public static <T extends BaseRestDTO> Optional<RestDtoConverter> createRestDtoConverter(Class<T> dtoType) {
		
		ClassPathScanningCandidateComponentProvider scanner = prepareScanner(RestConverter.class);
		
		for (BeanDefinition beanDef : scanner.findCandidateComponents(BASE_PACKAGE_REST)) {
			try {
				Class<?> converterClass = Class.forName(beanDef.getBeanClassName());
				RestConverter annotation = converterClass.getAnnotation(RestConverter.class);
				String dtoNameWithoutSuffix = dtoType.getSimpleName().
						substring(0, dtoType.getSimpleName().length() - REST_SUFFIX_LENGTH);
				
				if (annotation.dto().toLowerCase().contentEquals((dtoNameWithoutSuffix.toLowerCase()))) {
					return (Optional<RestDtoConverter>) 
							Optional.of((RestDtoConverter)Class.forName(beanDef.getBeanClassName()).newInstance());
				}
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				LOGGER.error("Problemas ao criar o conversor. Mensagem = {}", e.getMessage());
			}
		}
		return Optional.empty();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static ClassPathScanningCandidateComponentProvider prepareScanner(Class annotationClass) {
		ClassPathScanningCandidateComponentProvider scanner = 
				new ClassPathScanningCandidateComponentProvider(true);
		scanner.addIncludeFilter(new AnnotationTypeFilter(annotationClass));
		return scanner;
	}
}
