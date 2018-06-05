import Lesson1.Observer.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccidentDispatcherTest {

    private AccidentDispatcher accidentDispatcher;

    @Mock
    private Ambulance ambulance;

    @Mock
    private Statistician statistician;

    @Mock
    private AgentAbw agentAbw;

    @Before
    public void setup() {
        accidentDispatcher = new AccidentDispatcher();
    }

    @Test
    public void shouldNotifyObserversWhenAccidentHappened() {
        //given
        accidentDispatcher.addObserver(ambulance);
        accidentDispatcher.addObserver(statistician);
        accidentDispatcher.addObserver(agentAbw);

        //when
        accidentDispatcher.setAccidentType(TypeOfAccident.POWÓDŹ);
        accidentDispatcher.notifyObservers();

        //then
        verify(ambulance).update(accidentDispatcher, TypeOfAccident.POWÓDŹ);
        verify(statistician).update(accidentDispatcher, TypeOfAccident.POWÓDŹ);
        verify(agentAbw).update(accidentDispatcher, TypeOfAccident.POWÓDŹ);
    }

    @Test
    public void shouldNotNotifyObserversWhenNoAccidentHappened() {
        //given
        accidentDispatcher.addObserver(ambulance);
        accidentDispatcher.addObserver(statistician);
        accidentDispatcher.addObserver(agentAbw);

        //when
        accidentDispatcher.notifyObservers();

        //then
        verify(ambulance, never()).update(eq(accidentDispatcher), any());
        verify(statistician, never()).update(eq(accidentDispatcher), any());
        verify(agentAbw, never()).update(eq(accidentDispatcher), any());
    }

    @Test
    public void shouldNotNotifyObserversWhenDeleted() {
        //given
        accidentDispatcher.addObserver(ambulance);
        accidentDispatcher.addObserver(statistician);
        accidentDispatcher.addObserver(agentAbw);
        accidentDispatcher.deleteObserver(ambulance);
        accidentDispatcher.deleteObserver(statistician);
        accidentDispatcher.deleteObserver(agentAbw);

        //when
        accidentDispatcher.setAccidentType(TypeOfAccident.POŻAR);
        accidentDispatcher.notifyObservers();

        //then
        verify(ambulance, never()).update(eq(accidentDispatcher), any());
        verify(statistician, never()).update(eq(accidentDispatcher), any());
        verify(agentAbw, never()).update(eq(accidentDispatcher), any());
    }

    @Test
    public void shouldNotNotifyObserversWhenNotAdded() {
        //when
        accidentDispatcher.setAccidentType(TypeOfAccident.ZAGROŻENIE_BIOLOGICZNE);
        accidentDispatcher.notifyObservers();

        //then
        verify(ambulance, never()).update(eq(accidentDispatcher), any());
        verify(statistician, never()).update(eq(accidentDispatcher), any());
        verify(agentAbw, never()).update(eq(accidentDispatcher), any());
    }
}
