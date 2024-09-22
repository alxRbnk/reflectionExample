package org.rbnk.reflection.deprecated.impl;

import org.rbnk.reflection.entity.Customer;
import org.rbnk.reflection.entity.Order;
import org.rbnk.reflection.entity.Product;
import org.rbnk.reflection.deprecated.CustomParser;

import java.time.LocalDate;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated(forRemoval = true)
public class CustomParserImpl implements CustomParser {

    @Override
    public Map<String, Object> parseJson(String text) {
        if (text.charAt(0) != '{'
                && text.charAt(0) != '[') {
            throw new IllegalArgumentException("invalid json file");
        }
        System.out.println(text);
        Customer customer = collectCustomer(text);
        return Map.of();
    }


    private Customer collectCustomer(String text) {
        Customer customer = new Customer();
        Order order = new Order();
        Product product = new Product();
        customer.setId(getJsonId(text));
        customer.setFirstName(getJsonFirstName(text));
        customer.setLastName(getJsonLastName(text));
        customer.setDateBirth(getJsonDateBirth(text));
        return customer;
    }

    private Long getJsonId(String text) {
        long id = 0L;
        String regex = "\"id\":\\s*\"(\\d+)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String element = matcher.group(1);
            id = Long.parseLong(element);
        }
        return id;
    }

    private String getJsonFirstName(String text) {
        String firstName = "";
        String regex = "\"firstName\":\s*\"([^\"]+)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String element = matcher.group(1);
            firstName =  element;
        }
        return firstName;
    }

    private String getJsonLastName(String text) {
        String lastName = "";
        String regex = "\"lastName\":\s*\"([^\"]+)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String element = matcher.group(1);
            lastName =  element;
        }
        return lastName;
    }

    private LocalDate getJsonDateBirth(String text) {
        LocalDate birthDate = LocalDate.now();
        String regex = "\"dateBirth\":\\s*\"(\\d{4}-\\d{2}-\\d{2})\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String element = matcher.group(1);
            birthDate =  LocalDate.parse(element);
        }
        return birthDate;
    }
}
