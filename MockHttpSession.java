package com.hsaini.studentapp;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;

public class MockHttpSession implements HttpSession {
    private final HashMap<String, Object> attributes = new HashMap<>();
    private boolean isNew = true;

    @Override
    public long getCreationTime() {
        return 0; // Replace with your logic
    }

    @Override
    public String getId() {
        return null; // Replace with your logic
    }

    @Override
    public long getLastAccessedTime() {
        return 0; // Replace with your logic
    }

    @Override
    public ServletContext getServletContext() {
        return null; // Replace with your logic
    }

    @Override
    public void setMaxInactiveInterval(int interval) {
        // Replace with your logic
    }

    @Override
    public int getMaxInactiveInterval() {
        return 0; // Replace with your logic
    }

    @Override
    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return null; // Replace with your logic
    }

    @Override
    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    @Override
    public void removeAttribute(String name) {
        attributes.remove(name);
    }

    @Override
    public void invalidate() {
        attributes.clear();
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    // Additional methods and logic can be added as needed
}
