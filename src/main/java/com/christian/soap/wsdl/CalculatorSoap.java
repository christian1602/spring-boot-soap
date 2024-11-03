
package com.christian.soap.wsdl;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "CalculatorSoap", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CalculatorSoap {


    /**
     * Adds two integers. This is a test WebService. ©DNE Online
     * 
     * @param intB
     * @param intA
     * @return
     *     returns int
     */
    @WebMethod(operationName = "Add", action = "http://tempuri.org/Add")
    @WebResult(name = "AddResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "Add", targetNamespace = "http://tempuri.org/", className = "com.christian.soap.wsdl.Add")
    @ResponseWrapper(localName = "AddResponse", targetNamespace = "http://tempuri.org/", className = "com.christian.soap.wsdl.AddResponse")
    public int add(
        @WebParam(name = "intA", targetNamespace = "http://tempuri.org/")
        int intA,
        @WebParam(name = "intB", targetNamespace = "http://tempuri.org/")
        int intB);

    /**
     * 
     * @param intB
     * @param intA
     * @return
     *     returns int
     */
    @WebMethod(operationName = "Subtract", action = "http://tempuri.org/Subtract")
    @WebResult(name = "SubtractResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "Subtract", targetNamespace = "http://tempuri.org/", className = "com.christian.soap.wsdl.Subtract")
    @ResponseWrapper(localName = "SubtractResponse", targetNamespace = "http://tempuri.org/", className = "com.christian.soap.wsdl.SubtractResponse")
    public int subtract(
        @WebParam(name = "intA", targetNamespace = "http://tempuri.org/")
        int intA,
        @WebParam(name = "intB", targetNamespace = "http://tempuri.org/")
        int intB);

    /**
     * 
     * @param intB
     * @param intA
     * @return
     *     returns int
     */
    @WebMethod(operationName = "Multiply", action = "http://tempuri.org/Multiply")
    @WebResult(name = "MultiplyResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "Multiply", targetNamespace = "http://tempuri.org/", className = "com.christian.soap.wsdl.Multiply")
    @ResponseWrapper(localName = "MultiplyResponse", targetNamespace = "http://tempuri.org/", className = "com.christian.soap.wsdl.MultiplyResponse")
    public int multiply(
        @WebParam(name = "intA", targetNamespace = "http://tempuri.org/")
        int intA,
        @WebParam(name = "intB", targetNamespace = "http://tempuri.org/")
        int intB);

    /**
     * 
     * @param intB
     * @param intA
     * @return
     *     returns int
     */
    @WebMethod(operationName = "Divide", action = "http://tempuri.org/Divide")
    @WebResult(name = "DivideResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "Divide", targetNamespace = "http://tempuri.org/", className = "com.christian.soap.wsdl.Divide")
    @ResponseWrapper(localName = "DivideResponse", targetNamespace = "http://tempuri.org/", className = "com.christian.soap.wsdl.DivideResponse")
    public int divide(
        @WebParam(name = "intA", targetNamespace = "http://tempuri.org/")
        int intA,
        @WebParam(name = "intB", targetNamespace = "http://tempuri.org/")
        int intB);

}