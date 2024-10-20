import java.util.Arrays;

/*

Jeff travels from West to East
We have cities array which gives the list of cities as String array
We have distances array which gives the list of distances of cities from west.

There are two rules:
1. Jeff only travels towards West, he can't go towards East at any point
2. Jeff travels from city to city in a lexicographical order

Return the maximum numbers of cities Jeff can travel

Example:
cities: [Delhi, Bangalore, Chennai, Nepal, Calcutta, Mumbai]
distances: [100, 80, 150, 55, 90, 78]

Answer: 3
Explanation:
[Bangalore -> Calcutta -> Delhi] are the cities in lexicographical order as well as
in increasing order of distances [80 < 90 < 100]

 */
public class MaximumNumberOfCities {

    public static int maxCities(String[] cities, int[] distances) {
        int n = cities.length;

        // Combine cities and distances into pairs
        City[] cityArray = new City[n];
        for (int i = 0; i < n; i++) {
            cityArray[i] = new City(cities[i], distances[i]);
        }

        // Sort cityArray first by distance, then by city name
        Arrays.sort(cityArray, (a, b) -> {
            if (a.distance != b.distance) {
                return Integer.compare(a.distance, b.distance);
            }
            return a.name.compareTo(b.name);
        });

        // Dynamic programming array to find the longest increasing subsequence
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // At least each city can be visited alone

        // Find the maximum number of cities that can be visited
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Check the lexicographical order of city names
                if (cityArray[i].name.compareTo(cityArray[j].name) > 0 && cityArray[i].distance > cityArray[j].distance) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // The result is the maximum value in dp
        int maxCities = 0;
        for (int count : dp) {
            maxCities = Math.max(maxCities, count);
        }

        return maxCities;
    }

    // Helper class to hold city information
    static class City {
        String name;
        int distance;

        City(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "City{" +
                    "name='" + name + '\'' +
                    ", distance=" + distance +
                    '}';
        }
    }

    public static void main(String[] args) {
        String[] cities = {"Delhi", "Bangalore", "Chennai", "Nepal", "Calcutta", "Mumbai"};
        int[] distances = {100, 80, 150, 55, 90, 78};

        int result = maxCities(cities, distances);
        System.out.println("Maximum number of cities Jeff can travel: " + result);
    }
}
