package it.tasgroup.xtderp.xtdplatform.metadata.model;

import lombok.RequiredArgsConstructor;
import org.junit.*;

import java.util.Iterator;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class ClassModelTest {

    @Test
    public void testId() {

        ClassModel<TestModel> model = new ClassModel<>(TestModel.class);

        assertThat("Id is the name of the class", TestModel.class.getName(), equalTo(model.id()));
    }

    @Test
    public void testAttributes() {

        ClassModel<TestModel> model = new ClassModel<>(TestModel.class);

        for (Attribute attribute : model) {
            System.out.println(attribute);
        }
    }

    @RequiredArgsConstructor
    class TestModel {

        private final String id;

        private final String name;
    }
}