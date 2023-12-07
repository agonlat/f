package com.example.fluganzeigetafel;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataInterface {
    private static DataInterface instance;
    private List<Flight> flights;

    private String filePath;
    private int changedFlightsCounter;
    public static FlightsTable flightsTable;

    public int getChangedFlightsCounter() {
        return changedFlightsCounter;
    }

    public void incrementCounter() {
        this.changedFlightsCounter++;
    }

    public HashMap<String, Integer> getAirlines() {
        HashMap<String, Integer> map = new HashMap<>();

        for (Flight f : flights) {
            String airline = UtilityMethods.getAirlineCode(f.getFnr());

            // Check if the airline is already in the map
            if (map.containsKey(airline)) {
                // If yes, get the current count, increment it, and put it back in the map
                int currentCount = map.get(airline);
                map.put(airline, currentCount + 1);
            } else {
                // If no, add the airline to the map with a count of 1
                map.put(airline, 1);
            }
        }

        return map;
    }


    private DataInterface() {
        flights = new ArrayList<>();
        filePath = "";
        changedFlightsCounter = 0;

    }

    public static DataInterface getInstance() {

            synchronized (DataInterface.class) {
                if (instance == null)  {
                    instance = new DataInterface();
                }

            }


        return instance;
    }

    public List<Flight> getFlights() {
        return flights;
    }



    public String getFilePath() {
        return filePath;
    }

    public boolean setFilePath(final String filePath) {
        if (filePath != null || !filePath.isEmpty() ) {
            this.filePath = filePath;
            return true;
        }


        return false;
    }

    public boolean addFlights(List<Flight>flights) {

        if (flights != null)
        this.flights = flights;


        return this.flights != null;
    }





}
