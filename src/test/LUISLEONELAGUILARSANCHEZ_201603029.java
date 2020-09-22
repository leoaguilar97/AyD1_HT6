/*
*   HOJA DE TRABAJO #6
*   ANALISIS Y DISENIO DE SISTEMAS 1
*   LUIS LEONEL AGUILAR SANCHEZ - 201603029
 */
package test;

import Objetos.Carrera;
import Objetos.RegistroAcademico;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;


/*
    autor: leoag
*/
public class LUISLEONELAGUILARSANCHEZ_201603029 {

    
    RegistroAcademico registroAcademicoMock = mock(RegistroAcademico.class);

    /*
        Al registrar un carne valido este devuelve true cuando
        se realiza el checkeo del carne
    */
    @Test
    public void ChequearCarneRetornaVerdaderoAlSerValido() throws Exception
    {
        registroAcademicoMock = new RegistroAcademico(2016, "03029");
        Assert.assertTrue(registroAcademicoMock.cheequearCarnet());
    }

    /*
        Al generar horario y enviar un carne invalido
        el metodo realiza un raise exception 
    */
    @Test
    public void GenerarHorarioRaiseExceptionCuandoElCarneEsInvalido() throws Exception{

        registroAcademicoMock = new RegistroAcademico(1899, "incorrecto");

        Carrera carreraMock = mock(Carrera.class);
        carreraMock = new Carrera(9, "Sistemas");

        AsignarHorario asignacion = new AsignarHorario();
        AsignarHorario asignacionMock = mock(AsignarHorario.class);

        doThrow(Exception.class).when(asignacionMock).generarHorario(carreraMock, registroAcademicoMock);

        Exception exception = null;

        try {
            asignacion.generarHorario(carreraMock, registroAcademicoMock);
        } catch(Exception e){
            exception = e;
        }

        Assert.assertNotNull(exception);
    }
}
