# HomeBase Distributed Application

HomeBase is a semester-long project developed for an **Enterprise-Wide
Computing** course. The project demonstrates a distributed application
architecture in which multiple applications provide access to data
stored in a **shared relational database**.

HomeBase is a personal home management system designed to help users
keep track of items and information related to their home. Rather than
relying on a single interface, the system provides three different ways
to access and manage the same data:

-   **Web application**
-   **Desktop application**
-   **Mobile application**

Each application connects to the shared HomeBase data, allowing users to
manage their information from different devices and environments.

------------------------------------------------------------------------

## Purpose

The goal of HomeBase was to explore how an enterprise-wide application
can provide multiple interfaces while maintaining a shared source of
data.

A user may not always have access to the same device or application. For
example, someone may be traveling without access to their computer, may
need to use a mobile device, or may prefer to access the system through
a web browser. HomeBase provides multiple application interfaces so the
same home information can be accessed in different ways.

This design demonstrates how separate applications can work with shared
data while providing interfaces suited to different environments.

------------------------------------------------------------------------

## Application Architecture

HomeBase consists of three application interfaces that work with a
shared database:

``` text
                     ┌─────────────────────┐
                     │   HomeBase Web App  │
                     └──────────┬──────────┘
                                │
                                │
┌──────────────────────┐        │        ┌──────────────────────┐
│ HomeBase Desktop App │────────┼────────│ HomeBase Mobile App  │
└──────────────────────┘        │        └──────────────────────┘
                                │
                                ▼
                     ┌─────────────────────┐
                     │   Shared Database   │
                     └─────────────────────┘
```

The three applications provide different ways to interact with HomeBase
while working with the same underlying data.

### Web Application

The web application provides browser-based access to HomeBase. Users can
view and manage their home information without needing to use the
desktop application.

### Desktop Application

The desktop application provides a traditional computer interface for
accessing HomeBase and performing operations on information stored in
the shared database.

### Mobile Application

The mobile application provides access to HomeBase from a mobile device,
giving users another way to interact with their information when they
are away from their computer.

------------------------------------------------------------------------

## Features

HomeBase supports full **CRUD (Create, Read, Update, Delete)**
functionality for managing home information.

Users can:

-   **Create** new records
-   **Read** and view existing records
-   **Update** stored information
-   **Delete** records that are no longer needed
-   Access shared data through web, desktop, and mobile interfaces

Because the applications work with the same underlying data, information
created or modified through one interface can be accessed through the
other interfaces.

------------------------------------------------------------------------

## Technologies

Technologies used throughout the project include:

-   Java
-   HTML
-   CSS
-   JavaScript
-   NetBeans
-   JDBC
-   GlassFish
-   Relational database technologies
-   Web application development
-   Desktop application development
-   Mobile application development

------------------------------------------------------------------------

## Video Demo

A complete demonstration of the HomeBase distributed application is
available on YouTube.

[Watch the HomeBase Application Demo on YouTube](https://www.youtube.com/watch?v=soMRGthNvcE)

------------------------------------------------------------------------

## What I Learned

HomeBase provided hands-on experience building an application that
extends beyond a single user interface. Instead of developing one
standalone program, the project required thinking about how multiple
applications could provide access to shared data while serving users in
different environments.

Through this semester-long project, I gained experience with:

-   Developing applications with Java
-   Building web and desktop application interfaces
-   Working with a mobile application interface
-   Connecting applications to a relational database
-   Using JDBC for database connectivity
-   Implementing CRUD operations
-   Working with application servers
-   Using GlassFish with Java web applications
-   Troubleshooting application compatibility and deployment issues
-   Separating application components and business logic
-   Designing multiple interfaces around shared data
-   Integrating web technologies including HTML, CSS, and JavaScript



