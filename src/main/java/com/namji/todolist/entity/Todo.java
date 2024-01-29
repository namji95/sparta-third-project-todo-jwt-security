package com.namji.todolist.entity;

import com.namji.todolist.dto.Timestamped;
import com.namji.todolist.dto.TodoRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratedColumn;

import javax.swing.border.TitledBorder;
import java.net.PasswordAuthentication;

@Entity
@Table(name = "todo")
@Getter
@Setter
@NoArgsConstructor
public class Todo extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false, length = 255)
    private String content;

    @Column(name = "user", nullable = false)
    private String user;

    @Column(name = "password", nullable = false)
    private String password;

    public Todo (TodoRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.user = requestDto.getUser();
        this.password = requestDto.getPassword();
    }

    public void update (TodoRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.user = requestDto.getUser();
        this.password = requestDto.getPassword();
    }
}
