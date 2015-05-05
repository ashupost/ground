package com.ground.web.services.soap.handler;

import java.io.IOException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

public class MacAddressValidatorHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {

		System.out.println("Server : handleMessage()......");

		// Boolean isRequest = (Boolean)
		// context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		SOAPMessage soapMsg = context.getMessage();
		// SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
		// SOAPHeader soapHeader = soapEnv.getHeader();

		// for response message only, true for outbound messages, false for
		// inbound
		try {
			soapMsg.writeTo(System.out);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// continue other handler chain
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {

		System.out.println("Server : handleFault()......");

		return true;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("Server : close()......");
	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("Server : getHeaders()......");
		return null;
	}

	@SuppressWarnings("unused")
	private void generateSOAPErrMessage(SOAPMessage msg, String reason) {
		try {
			SOAPBody soapBody = msg.getSOAPPart().getEnvelope().getBody();
			SOAPFault soapFault = soapBody.addFault();
			soapFault.setFaultString(reason);
			throw new SOAPFaultException(soapFault);
		} catch (SOAPException e) {
		}
	}

}