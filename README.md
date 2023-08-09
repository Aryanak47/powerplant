# Virtual Power Plant System

The Virtual Power Plant System is a cloud-based energy aggregation platform that brings together distributed power sources into a unified energy provider. This project provides a REST API implemented using Spring Boot, offering functionalities for managing batteries within the power plant network.

## Features

- Battery Management: Add and retrieve battery information including name, postcode, and watt capacity.
- Range-Based Retrieval: Retrieve batteries falling within a specified postcode range, sorted alphabetically.
- Statistics: Get insights into total and average watt capacity of batteries within the requested range.
- Flexible Pagination: Support for efficient pagination of large datasets.

## API Endpoints

- `POST /api/batteries`: Save a new battery with name, postcode, and capacity.
- `GET /api/batteries/all`: Retrieve a list of all batteries.
- `GET /api/batteries/{id}`: Fetch a battery by its unique ID.
- `GET /api/batteries/all/range`: Retrieve batteries within a specified postcode range along with statistics.

## Hosted Application

The Virtual Power Plant System API is hosted at [Hosted URL]().

## Documentation

Detailed API documentation can be found [here](https://documenter.getpostman.com/view/11023757/2s9Xy2PBpb).

## Getting Started

To run this project locally, follow these steps:

1. Clone this repository: `git clone https://github.com/Aryanak47/powerplant.git`
2. Navigate to the project directory: `cd powerplant`
3. Install dependencies: `./gradlew clean build`
4. Run the application: `./gradlew bootRun`


