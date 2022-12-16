<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#improvements">Improvements</a></li>
  </ol>
</details>




<!-- ABOUT THE PROJECT -->
## About The Project

This project demonstrates simple implementation of elevator sysyem with an assumption of having only one elevator in place. This projects allows the user to configure requests for going up/down, as well as serves the purpose of an miscellaneous requests that comes when the elevator is serving existing requests.

More ever, projects please follow the project request flow diagram below:

[System Flow Diagram][flow-diagram]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

This section should list any major frameworks/libraries used to bootstrap your project. Here are a few examples.

* Offcourse Java :smile:
* Apache maven based project setup/hierarchy

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- GETTING STARTED -->
## Getting Started

Read carefully and follow below instructions in order to setup this project locally.

### Prerequisites

Following softwares had to be installed in order to setup this project locally. Please find the respective commands as well to check for installation:
* java
  ```sh
  java -version
  ```
* Apache MAVEN
  ```sh
  mvn -v
  ```

### Installation

_Please follow below steps in order to run this application locally:_

1. Clone the repo
   ```sh
   git clone https://github.com/chanchal-detani/elevator_system.git
   ```	
3. Run following command in order to generate binaries:
   ```sh
   mvn clean install
   ```
4. Run following command to run this elevator system:
   ```sh
   java -jar target\elevator-system-0.0.1-SNAPSHOT.jar
   ```
<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

- [x] Add required information about the elevator initial state
- [x] Add required information about the mobility requests
- [x] Run application using main method as Java Application

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Chanchal Detwani- [@LinkedIn](https://www.linkedin.com/in/chanchal-detwani) - chanchaldetani@gmail.com

Project Link: [https://github.com/chanchal-detani/elevator_system](https://github.com/chanchal-detani/elevator_system)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- IMPROVEMENTS -->
## Improvements

Due to the time constraints, I am not able to add more functionalities to this Elevator System, but yeah I have tried listing those below!

* Exposing API's to raise mobility requests dynamically
* Integrating with 3rd party to get updates of the elevator and also to pass commands to the elevator
* Enabling Security
* Enabling distributed tracing
* Enabling CDR for request auditing
* Enabling Rate Limiting off course since we will be exposing APIs
* Extending the logic to support multiple elevators
* Code Optimizations by doing some code refactoring & enhancements
* Unit & Integration test-cases to increase code coverage

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
[flow-diagram]: images/flow-diagram.jpg