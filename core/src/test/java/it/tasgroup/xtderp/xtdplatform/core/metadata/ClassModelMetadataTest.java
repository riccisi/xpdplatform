package it.tasgroup.xtderp.xtdplatform.core.metadata;

import it.tasgroup.xtderp.xtdplatform.core.localization.I18n;
import it.tasgroup.xtderp.xtdplatform.core.metadata.reflect.ClassModelMetadata;
import lombok.RequiredArgsConstructor;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ClassModelMetadataTest {

    @Test
    public void testId() {

        ClassModelMetadata<TestModel> model = new ClassModelMetadata<>(TestModel.class, new I18n.Fake());

        assertThat("Id is the name of the class", TestModel.class.getName(), equalTo(model.id()));
    }

    @Test
    public void testAttributes() {

        ClassModelMetadata<TestModel> model = new ClassModelMetadata<>(TestModel.class, new I18n.Fake());

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