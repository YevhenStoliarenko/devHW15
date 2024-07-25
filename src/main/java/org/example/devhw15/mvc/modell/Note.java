package org.example.devhw15.mvc.modell;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Scope("prototype")
@Component
@Data
public class Note {
    private Long id;
    private String title;
    private String content;


    public Note() {
        Random rand = new Random();
        this.id = rand.nextLong(10);
    }
}