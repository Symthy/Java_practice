package powermock_testJ4.service;

//import powermock_testJ4.service.DummyRunner;
import powermock_testJ4.arg.ArgumentOne;
import powermock_testJ4.arg.ArgumentTwo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.any;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
//import org.junit.jupiter.api.Test;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Service.class })
public class ServiceTest {

  Service service = new Service();

  @Test
  public void execute() throws Exception {
    DummyRunner mock = mock(DummyRunner.class);
    whenNew(DummyRunner.class).withAnyArguments().thenReturn(mock);
    when(mock.run()).thenReturn("test");

    String result = service.execute();
    Assert.assertEquals(result, "test");
    verifyNew(DummyRunner.class).withArguments(any(ArgumentOne.class));
    // This verify is failure
    // verifyNew(DummyRunner.class).withArguments(any(ArgumentTwo.class));
    System.out.println(result);
  }

}
