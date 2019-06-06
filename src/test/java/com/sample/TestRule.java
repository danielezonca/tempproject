package com.sample;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

public class TestRule {

    static KieSession session;

    @BeforeClass
    public static void setUpClass() throws Exception {
        session = KieServices.get().newKieClasspathContainer().newKieSession();
    }

    @Test
    public void testRule() {
        Assert.assertNotNull(session);

        ItemCity item1 = new ItemCity();
        item1.setPurchaseCity(ItemCity.City.PUNE);
        item1.setTypeofItem(ItemCity.Type.MEDICINES);
        session.insert(item1);
        session.fireAllRules();
    }
}