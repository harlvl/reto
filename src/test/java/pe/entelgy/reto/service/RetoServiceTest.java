package pe.entelgy.reto.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RetoServiceTest {

    @Mock
    private RetoService underTest;

    @Test
    void canRework() {
        Assertions.assertNotNull(underTest);

        underTest.rework();
        verify(underTest).rework();
    }

    @Test
    void canJoinData() {
        Assertions.assertNotNull(underTest);

        //datos de prueba
        ArrayList<Object> data = new ArrayList<>();
        LinkedHashMap<String, Object> item = new LinkedHashMap<>();
        item.put("id", 1);
        item.put("last_name", "Viguria");
        item.put("email", "luis@gmail.com");
        data.add(item);

        underTest.joinUserData(data);
        verify(underTest).joinUserData(data);
    }
}