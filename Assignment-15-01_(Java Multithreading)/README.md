# Taxi Stand (Java multithreading)

## Working of the TaxiStand

### TaxiStand.java

- Consists of :
  - Unbonded TaxiQueue.
  - Unbounded PassengerQueue.
  - Taxi stand with **_TaxiStand.TAXI_STAND_SIZE_** slots.
- Initialises the **_TaxiGenerator_** and **_PassengerGenerator_** on seperate threads.

### TaxiGenerator.java

- Generates a new **_Taxi_** at random intervals between **_TaxiGenerator.MIN_DELAY_** seconds and **_TaxiGenerator.MAX_DELAY_** seconds.
- Newly generated taxi is added to the TaxiQueue.
- Newly generated taxi has no destination and **_Taxi.TAXI_SIZE_** unoccupied seats.

### PassengerGenerator.java

- Generates a new **_Passenger_** at random intervals between **_PassengerGenerator.MIN_DELAY_** milliseconds and **_PassengerGenerator.MAX_DELAY_** milliseconds.
- Newly generated Passenger is added to the Passenger Queue.
- Passenger is generated with a random destination from locations present in **_Location_**.

### Taxi.java

- Each taxi has an ID, destination (initially null) and a set of seats (initially unoccupied).
- Each taxi runs an independent thread which starts on joining the TaxiQueue.
- Each taxi can be present in three states : **_WAITING_IN_QUEUE_**, **_WAITING_FOR_PASSENGERS_** and **_READY_TO_DEPART_**
- The taxi observes it's position in the Taxi queue every **_Taxi.DRIVER_OBSERVATION_DELAY_** seconds.
- If the taxi is at the head of the TaxiQueue and there exists an empty slot in the TaxiStand, the taxi leaves the TaxiQueue and joins the TaxiStand.
- The taxi leaves the TaxiStand when all the seats are completely occupied by passengers or the taxi has waitied at the stand for longer than **_Taxi.MAX_STAND_WAIT_TIME_**.

### Passenger.java

- Each passenger has an ID and a destination.
- Each passenger runs an independent thread which starts on joining the PassengerQueue.
- Each passenger can present in two states : **_WAITING_IN_QUEUE_**, **_SITTING_IN_TAXI_**.
- The passenger observes it's position in the PassengerQueue every **_Passenger.OBSERVATION_DELAY_** milliseconds.
- If the passenger is at the head of the PassengerQueue, the passenger checks for the following conditions:
  - If there exists a taxi at the stand with atleast one unoccupied seat and no destination, the passengers leaves the PassengerQueue, occupies a seat at that taxi and causes the taxi to set it's destination to the passenger's destination.
  - If there exists a taxi at the stand with atleast one unoccupied seat and the same destination as that of the taxi, the passengers leaves the PassengerQueue and occupies a seat at that taxi.

## Result

[output.txt](output.txt)
