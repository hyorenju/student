package vn.edu.vnua.fita.student.service.iservice;


import vn.edu.vnua.fita.student.request.ForgotPasswordRequest;
import vn.edu.vnua.fita.student.request.SendMailRequest;

public interface ForgotPasswordService {
    void sendMessage(SendMailRequest request);
    boolean checkToken(String token);
    void changePassword(ForgotPasswordRequest request);

}
