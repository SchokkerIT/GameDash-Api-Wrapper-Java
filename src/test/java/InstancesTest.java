import com.gamedash.api.client.instance.Instance;
import com.gamedash.api.client.instance.Instances;
import org.junit.jupiter.api.Test;

class InstancesTest {

    private static Instance[] instances;

    private Instance[] getAll() throws Exception {

        if( InstancesTest.instances == null ) {

            InstancesTest.instances = Instances.getAll();

        }

        return InstancesTest.instances;

    }

    @Test
    void getStatus() throws Exception {

        Instance instance = Instances.getAll()[0];

        instance.getProcess().getStatus();

    }

    @Test
    void changeStatus() throws Exception {

        Instance instance = Instances.getAll()[0];

        if( instance.getProcess().getStatus() ) {

            instance.getProcess().stop();

        }
        else {

            instance.getProcess().start();

        }

    }

}
