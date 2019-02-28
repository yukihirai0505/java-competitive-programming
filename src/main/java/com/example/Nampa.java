package com.example;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class Solution {

    private static int getHour() {
        Date now = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(now);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    private static void setGokon() {
        int hour = getHour();
        // The Nampa skill depends on the man, so you can change it between 1 and 100
        NampaMan nampaMan = new NampaMan(/*skill*/20);
        // It's golden time for the Nampa from 8 pm to 2am
        if (hour > 20 || hour < 2) {
            while (!nampaMan.getNampaResult()) {
                nampaMan.nampa();
            }
        }
        System.out.println("Set the Nampa Schedule from 8 pm to 2 am");
    }

    public static void main(String[] args) {
        setGokon();
    }
}

class NampaMan {

    private int nampaCount;
    private boolean nampaResult;
    private int skill;

    NampaMan(int skill) {
        this.nampaCount = 0;
        this.nampaResult = false;
        // Skill must be between 1 and 100
        this.skill = skill > 0 && skill <= 100 ? skill : 1;
    }

    void nampa() {
        nampaCount += 1;
        System.out.println((nampaCount) + " times nampa");
        nampaResult = new Random().nextInt(100) < skill;
        if (!nampaResult & nampaCount > 0 && nampaCount % 100 == 0) {
            System.out.println("Update skill");
            updateSkill();
        }
        if (nampaResult) {
            System.out.println("Nampa success, Please exchange contact and set next Gokon");
        }
    }

    boolean getNampaResult() {
        return nampaResult;
    }

    private void updateSkill() {
        // Read books and Change your fashion etc.
        skill += 1;
    }
}