package com.zeroone.biospay;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeScheduler {

    public static void main(String[] args) {
        // Create a scheduled executor service
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        // Get the current time
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23); // Set the hour (24-hour format) to 11
        calendar.set(Calendar.MINUTE, 16);      // Set the minute to 13

        // Calculate the delay until the specified time
        long delay = calendar.getTimeInMillis() - System.currentTimeMillis();

        // If the specified time has already passed for today, add a day to the delay
        if (delay < 0) {
            delay += TimeUnit.DAYS.toMillis(1); // Add a day
        }

        // Schedule the task to run after the calculated delay
        executor.schedule(() -> {
            // Your task to be executed at the specified time
            System.out.println("Task executed at: " + new Date());
            // Add your task logic here
        }, delay, TimeUnit.MILLISECONDS);
    }
}
