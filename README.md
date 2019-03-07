[![Build Status](https://travis-ci.org/pedrobrigatto/bmt-reports.svg?branch=master)](https://travis-ci.org/pedrobrigatto/bmt-reports)

# bmt-reports
Building Manager Tool - reports module (backend)

Repository dedicated to the backend services of the Building Manager Tool

This is a software to manage huge infrastructure buildings of great companies in the field of Oil & Gas. These buildings are huge and need a system that not only eliminates human errors that may occur when dealing with physical reports, but also offer an auditable and traceable operation, overall.

It will consist on the following API:

## /api/contracts

* Lists all contracts
* Creates a brand new contract

## /api/contracts/{contract_number}

* Edit a contract
* Lists the details of a particular contract (along with its operations)

## /api/contracts/{contract_number}/operations

* Lists all the operations of a particular contract
* Creates a brand new operation and associates it with a contract

