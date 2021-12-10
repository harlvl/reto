package pe.entelgy.reto.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import pe.entelgy.reto.util.ReadProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.entelgy.reto.util.exception.GenericRestException;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@Service
public class RetoService {
    private static final Logger LOG = LoggerFactory.getLogger(RetoService.class);
    @Autowired
    private ReadProperties readProperties;

    public ArrayList<String> rework() throws GenericRestException, HttpClientErrorException, HttpServerErrorException {
        LOG.info("[----  START  ----] RetoService.rework");

        String endpoint = readProperties.getProperty("regres.users.endpoint");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(endpoint, Object.class);

        LinkedHashMap<String, Object> body = (LinkedHashMap<String, Object>) responseEntity.getBody();

        if (body == null) {
            throw new GenericRestException("NO DATA PRESENT IN REGRES API");
        }

        ArrayList<Object> users = (ArrayList<Object>) body.get("data");

        LOG.info("[----  END  ----] RetoService.rework");
        return joinUserData(users);
    }


    public ArrayList<String> joinUserData(ArrayList<Object> users) {
        ArrayList<String> result = new ArrayList<>();

        for (Object user : users) {
            StringBuilder data = new StringBuilder();
            LinkedHashMap<String, Object> item = (LinkedHashMap<String, Object>) user;
            data.append(item.get("id").toString());
            data.append("|");
            data.append(item.get("last_name").toString());
            data.append("|");
            data.append(item.get("email").toString());
            result.add(data.toString());
        }

        return result;
    }
}
