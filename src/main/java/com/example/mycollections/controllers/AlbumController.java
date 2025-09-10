package com.example.mycollections.controllers;

import com.example.mycollections.models.Album;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("albums")
public class AlbumController {

    private final List<Album> albums = new ArrayList<>() {{
        add(new Album("Dark Side of the Moon", 1973, "Pink Floyd", 10));
        add(new Album("7th Symphony", 2010, "Apocalyptica", 10));
        add(new Album("5", 1999, "Lenny Kravitz", 15));
    }};

    @GetMapping("json")
    private List<Album> getAlbumsJson() { return albums; }

    @GetMapping("html")
    private String getAlbumsHtml() {
        String albumList = "<ul>";
        for (Album album : albums) {
            albumList += "<li>" + album + "</li>";
        }
        albumList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Albums</h1>
                        <ul>
                """ +
                albumList +
                """
                        </ul>
                    </body>
                """;
    }
}
