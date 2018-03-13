package it.tasgroup.xtderp.xtdplatform.metadata.model;

import lombok.RequiredArgsConstructor;
import org.junit.*;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class ClassModelMetadataTest {

    @Test
    public void testId() {

        ClassModelMetadata<TestModel> model = new ClassModelMetadata<>(TestModel.class);

        assertThat("Id is the name of the class", TestModel.class.getName(), equalTo(model.id()));
    }

    @Test
    public void testAttributes() {

        ClassModelMetadata<TestModel> model = new ClassModelMetadata<>(TestModel.class);

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