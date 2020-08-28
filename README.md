# RAMP SDK Getting Started

<p align="left">
  <img width="100" src="https://github.com/DSG-UniFE/rampSDK/blob/master/images/RAMP-SDKlogo.png?raw=true" alt="RAMP SDKE Logo"/>
</p>

Multi-Layer Advanced Networking Environment (Multi-LANE) middleware, originally adopts a Multi Layer Routing (MLR) approach in conjunction with SDN to fully enhance the capabilities of heterogeneous Fog environments.

This repository contains the RAMP Software Development Kit needed to define new Data Types and new Data Plane Rules that can be dynamically deployed and activated in a RAMP Multi-LANE environment.

## Setup Project and Libraries

* Clone this repository
* Add the jar libraries contained in the `libs` folder to the project. For example by using IntelliJ IDEA, once cloned this repository, type `CTRL+SHIFT+ALT+S` to open the settings; on the left-side panel click on `Libraries` in the `Project Settings` section; On the right-side panel click on the `+` button e select the libraries contained in the `libs` folder.

## Define a new Data Type

In RAMP Multi-LANE a Data Type is an application level message that can be exchanged between two ControllerClients.

A Data Type is a Java class that extends the class `AbstractDataType` and that implements the `Serializable` interface. In a RAMP Multi-LANE island, a Data Type is globally identified by its serialVersionUID so it must always be present.

In order to define a new Data Type, you need to create a new Java class in the `src` folder. As working example take a look on `TestVibrationDataType` class.

## Define a new Data Plane Rule

In RAMP Multi-LANE a Data Plane Rule is an high-level component that can manage traffic with fine-grained policies that can be deployed and activated at run-time. Depending on the developer choice, a Data Plane Rule can handle one or more Data Types. 

A Data Pane Rule is a Java class that extends the class `AbstractDataPlaneRule` and that implements the `Serializable` interface. In a RAMP Multi-LANE island, a Data Plane Rule is globally identified  by its serialVersionUID so it must always be present.

In order to define a new Data Plane Rule, you need to create a new Java class in the `src` folder. As working example take a look on `TestVibrationDataPlaneRule` class.

The Data Plane Rule, if compared with a Data Type, is an active component. In fact it can interact with other RAMP components by using the `ComponentLocator` module to fulfill its business logic. At the moment the `ComponentLocator` provides the access to:
* ControllerClient, check `ControllerClientInterface`
* DataTypesManager, check `DataTypesManagerInterface`
* RampUtils, check `RampUtilsInterface`

## Build Data Types and Data Plane Rules

The run-time deployment of a new Data Type and/or a new Data Plane Rule is performed by uploading .class files by using the ControllerService. The ControllerService will start a protocol that disseminates the .class files to the active ControllerClients. These .class file will be loaded at run-time by using Java reflection.

So, once developed the Data Type and the Data Plane Rule, we need to compile them in order to get their .class version that can be used into RAMP Multi-LANE.

The build process is simple, you just need to compile the entire project (the main is the `RampSDKCompiler` class). Once compiled you can find .class files in the `out` folder. You can copy .class files in your preferred location and use them by using the SDNControllerService GUI application ([check this tutorial](https://github.com/DSG-UniFE/ramp/blob/master/deployment/README.md)).

## SDK Implementation Insights and Extensions

The main goal of this SDK is to make easier the development of new Data Types and Data Plane Rules for RAMP Multi-LANE. In order to do that was needed to extract from the [RAMP code](https://github.com/DSG-UniFE/ramp/blob/master/deployment/README.md) only the core components needed to build the classes correctly. The usage of interfaces trough the `ComponentLocator` class makes things well separated.

The side-effect of this approach is that every time there is a core change in the RAMP code this SDK must be updated accordingly. So everytime there is the need to introduce new components or change the services exposed by an interface this SDK must reflect these changes.

The only interfaces currently exposed by the `ComponentLocator` module are:
* ControllerClient, check `ControllerClientInterface`
* DataTypesManager, check `DataTypesManagerInterface`
* RampUtils, check `RampUtilsInterface`

These interfaces are also present in the RAMP code and must be exactly the same.

In case a new component needs to be accessible from the `ComponentLocator` you need to update the `ComponentType` class.