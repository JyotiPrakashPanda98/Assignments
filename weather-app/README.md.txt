# Real-Time Weather Monitoring System

## Overview
The Real-Time Weather Monitoring System is designed to continuously monitor weather conditions by fetching data from the OpenWeatherMap API. The system aggregates daily weather data, providing insights into temperature trends and alerting users when specific weather thresholds are exceeded.

## Features
- **Real-Time Data Retrieval**: Fetches weather data every 5 minutes for multiple cities across India (Delhi, Mumbai, Chennai, Bangalore, Kolkata, Hyderabad).
- **Daily Weather Summary**: 
  - Computes and displays average, maximum, and minimum temperatures.
  - Identifies the dominant weather condition for each day.
- **Alerting System**: 
  - Configurable temperature thresholds (e.g., alert if temperature exceeds 35 degrees Celsius).
  - Sends alerts for extreme weather conditions based on user-defined parameters.
- **Data Visualization**: Provides summaries and alerts through console outputs.

## Data Source
- Weather data is retrieved from the [OpenWeatherMap API](https://openweathermap.org/).
- Users must sign up for a free API key to access the service.

## Installation
1. **Clone the Repository**:
   ```bash
   git clone <repository_url>
