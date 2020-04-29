package com.example.mycloudmusicapi.exception;

import com.example.mycloudmusicapi.response.Response;
import com.example.mycloudmusicapi.response.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestControllerAdvice(basePackages = "com.example.mycloudmusicapi")
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理系统异常,500错误，所有的异常都会在这里处理
     * @param e
     * @param httpServletRequest
     * @return
     */
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Response systemException(Throwable e, HttpServletRequest httpServletRequest){
        Response response = Response.filaed(ResponseCode.SYSTEM_ERROR);
        log.error("URL:{}，系统异常：" + httpServletRequest.getRequestURI(),e);
        return response;
    }

    /**
     * 处理自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    public Response myException(MyException e){
        return Response.filaed(e.getResponseCode());
    }

    /**
     * 处理找不到页面异常，还有bug
     * @return
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response notFondException(){
        return Response.filaed(ResponseCode.NOT_FOND);
    }

    /**
     * 捕获Validator异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Response validatorException(MethodArgumentNotValidException e){
        String msg = validatorHandle(e.getBindingResult().getFieldErrors());
        return Response.filaed(ResponseCode.PARAM_IS_INVALID,msg);
    }

    /**
     * Validator异常辅助方法
     * @param fieldErrors
     * @return
     */
    private String validatorHandle(List<FieldError> fieldErrors) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < fieldErrors.size(); i++){
            sb.append(fieldErrors.get(i).getDefaultMessage());
            sb.append(",");
        }
        return sb.toString();
    }

    /**
     * 捕获数据重复异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = DuplicateKeyException.class)
    public Response duplicateException(DuplicateKeyException e){
        return Response.filaed(ResponseCode.USER_HAS_EXISTED);
    }

    /**
     * 捕获json参数异常，HttpMessageNotReadableException：JSON格式有误
     * HttpMediaTypeNotSupportedException：不是JSON格式，
     * @return
     */
    @ExceptionHandler(value = {HttpMessageNotReadableException.class, HttpMediaTypeNotSupportedException.class})
    public Response notReadableException(HttpMessageNotReadableException e,HttpMediaTypeNotSupportedException e1){
        return Response.filaed(ResponseCode.PARAM_IS_INVALID,"JSON格式有误");
    }

}
