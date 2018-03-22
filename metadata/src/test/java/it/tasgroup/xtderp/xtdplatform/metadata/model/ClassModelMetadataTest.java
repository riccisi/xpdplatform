package it.tasgroup.xtderp.xtdplatform.metadata.model;

import it.tasgroup.xtderp.xtdplatform.metadata.model.reflect.ClassModelMetadata;
import lombok.RequiredArgsConstructor;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

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