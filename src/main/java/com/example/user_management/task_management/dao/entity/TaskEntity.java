package com.example.user_management.dao.entity;

import com.example.user_management.dto.TaskPriority;
import com.example.user_management.dto.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="priority")
    @Enumerated(EnumType.STRING)
    private TaskPriority taskPriority;
    @Column(name="deadline")
    private LocalDateTime deadline;
    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name  ="updated_at")
    private LocalDateTime updatedAt;
}
