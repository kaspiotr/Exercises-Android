package com.piotrkasprzyk.first;

import com.piotrkasprzyk.first.pojo.Contact;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class JsonDeserializerTest {
    @Test
    public void deserializeContact_gsonFile_getContacts() throws Exception {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(JsonDeserializerTest.class.getName());
            }
        };
        String gsonFileName = classLoader.getResource("contacts.json").getPath();
        List<Contact> contacts = JsonDeserializer.deserializeContact(gsonFileName);

        assertEquals("Tatiana", contacts.get(9).getFirstName());
    }
}