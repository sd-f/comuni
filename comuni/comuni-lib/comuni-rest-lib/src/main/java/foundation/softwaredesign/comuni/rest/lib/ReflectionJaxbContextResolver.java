/*
 */
package foundation.softwaredesign.comuni.rest.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import foundation.softwaredesign.comuni.boundary.lib.Answer;
import foundation.softwaredesign.comuni.boundary.lib.Question;
import foundation.softwaredesign.comuni.boundary.lib.annotation.Sentence;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@Provider
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ReflectionJaxbContextResolver implements ContextResolver<JAXBContext> {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionJaxbContextResolver.class);

  @Context
  JAXBContext currentJaxbContext;

  @Override
  public JAXBContext getContext(Class<?> type) {
    List<Class<?>> classes = new ArrayList<>();
    Reflections reflections = new Reflections(Constants.BOUNDARY_PACKAGE_NAME);

    // all sentences
    Set<Class<?>> annotated
        = reflections.getTypesAnnotatedWith(Sentence.class);

    // if master is incoming (Answer,Question) marshalling
    // if concrete type incoming then unmarshalling
    // depending on inbound/outbound traffing master classes
    // nee to be added to context at the end or at the start of array
    if (type.equals(Answer.class) || type.equals(Question.class)) {
      classes.addAll(annotated);
      classes.add(Question.class);
      classes.add(Answer.class);
    } else {
      classes.add(Question.class);
      classes.add(Answer.class);
      classes.addAll(annotated);
    }

    Class[] array = classes.toArray(new Class[0]);
    try {
      return JAXBContext.newInstance(array);
    } catch (JAXBException ex) {
      LOGGER.error(ex.getLocalizedMessage(), ex);
    }
    return currentJaxbContext;
  }

}
