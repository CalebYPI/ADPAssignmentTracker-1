package org.assignmentTracker.controller.task;

import org.assignmentTracker.entity.*;
import org.assignmentTracker.factory.AssignmentFactory;
import org.assignmentTracker.factory.SubjectFactory;
import org.assignmentTracker.factory.TaskFactory;
import org.assignmentTracker.factory.UserFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TaskControllerTest {

    private static final String ADMIN_USERNAME = "lecturer";
    private static final String ADMIN_PASSWORD = "lecturer-password";

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/task";
    Subject subject = SubjectFactory.createSubject("Application Development Practice", "ADP372S",
            "Arinze Anikwue", new Date(4554564));

    List<Admin> admins = new ArrayList<>();
    List<Member> members = new ArrayList<>();
    User user = UserFactory.createUser("William", "King", "passWill123", "williamK@cput.ac.za");

    Assignment assignment = AssignmentFactory.createAssignment("ADP 372S Domain-Driven Design", subject,
            new Date(4599564), admins, members, user);

    private Task task = TaskFactory.createTask(1, 215169751, 6);

    @Test
    public void a_create() {
        String url = baseUrl + "create";
        ResponseEntity<Task> postResponse = restTemplate.withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD).postForEntity(url, task, Task.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        task = postResponse.getBody();
        System.out.println("Created " + task);
    }

    @Test
    public void b_read() {
        String url = baseUrl + "read/" + task.getTaskId();
        System.out.println(url);
        ResponseEntity<Task> getResponse = restTemplate.withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD).getForEntity(url, Task.class);
        assertEquals(task.getTaskId(), getResponse.getBody().getTaskId());
    }

    @Test
    public void c_update() {
        Task updated = new Task.Builder().copy(task).setMemberId(1).build();
        String url = baseUrl + "update";
        ResponseEntity<Task> postResponse = restTemplate.withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD).postForEntity(url, updated, Task.class);
        assertEquals(task.getTaskId(), postResponse.getBody().getTaskId());
    }

    @Test
    public void d_getAll() {
        String url = "/all";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD).exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void e_delete() {
        String url = baseUrl + "delete/" + task.getTaskId();
        restTemplate.withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD).delete(url);
    }
}