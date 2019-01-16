package com.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class PhotoFile implements Comparable<PhotoFile> {
    private int index;
    private String ext;
    private String name;
    private Date createdOn;

    public PhotoFile(int index, String ext, String name, Date createdOn) {
        this.index = index;
        this.ext = ext;
        this.name = name;
        this.createdOn = createdOn;
    }

    public int getIndex() {
        return index;
    }

    public String getExt() {
        return ext;
    }

    public String getName() {
        return name;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    @Override
    public int compareTo(PhotoFile p) {
        if (getCreatedOn() == null || p.getCreatedOn() == null) {
            return 0;
        }
        return getCreatedOn().compareTo(p.getCreatedOn());
    }
}

class FormatPhotos {

    public String solution(String S) {
        String[] files = S.replaceAll(" ", "").split("\n");
        List<PhotoFile> photos = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        // save index and file name, add date
        for (int i = 0; i < files.length; i++) {
            String[] strs = files[i].split(",");
            String ext = strs[0].split("\\.")[1];
            String name = strs[1];
            String date = strs[2];
            DateFormat format = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
            try {
                map.put(name, map.getOrDefault(name, 0) +1);
                PhotoFile photoFile = new PhotoFile(i, ext, name, format.parse(date));
                photos.add(photoFile);
            } catch (ParseException e) {
                return "";
            }
        }
        Collections.sort(photos);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < files.length; i++) {
            String[] strs = files[i].split(",");
            String name = strs[1];
            int totalCount = map.get(name).toString().length();
            int order = 1;
            for (PhotoFile p : photos) {
                if (p.getIndex() == i) {
                    String format = "%0" + totalCount + "d";
                    sb.append(name).append(String.format(format, order)).append(".").append(p.getExt()).append("\n");
                    break;
                }
                if (name.equals(p.getName())) {
                    order++;
                }
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FormatPhotos formatPhotos = new FormatPhotos();
        System.out.println(formatPhotos.solution("photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11"));
    }
}
