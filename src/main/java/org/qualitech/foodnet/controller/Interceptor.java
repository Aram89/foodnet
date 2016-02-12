package org.qualitech.foodnet.controller;

import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.filter.AbstractRequestLoggingFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Aram Kirakosyan.
 */
public class Interceptor extends AbstractRequestLoggingFilter {

    private  static Logger logger = LogManager.getLogger(Interceptor.class);

    @Override
    protected void beforeRequest(HttpServletRequest httpServletRequest, String s) {
        logger.info(s);
    }

    @Override
    protected void afterRequest(HttpServletRequest httpServletRequest, String s) {

    }
}
