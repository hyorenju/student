package vn.edu.vnua.fita.student.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.vnua.fita.student.request.CheckMailTokenRequest;
import vn.edu.vnua.fita.student.request.ForgotPasswordRequest;
import vn.edu.vnua.fita.student.request.SendMailRequest;
import vn.edu.vnua.fita.student.service.iservice.ForgotPasswordService;

@RestController
@RequestMapping("visitor")
@RequiredArgsConstructor
public class ForgotPasswordController extends BaseController {
    private final ForgotPasswordService forgotPasswordService;

    @PostMapping("send-request")
    public ResponseEntity<?> sendRequest(@Valid @RequestBody SendMailRequest request) {
        forgotPasswordService.sendMessage(request);
        String message = "Yêu cầu đổi mật khẩu đã được gửi tới địa chỉ " + request.getUser().getEmail();
        return buildItemResponse(message);
    }

    @PostMapping("check-token")
    public ResponseEntity<?> checkToken(@Valid @RequestBody CheckMailTokenRequest request){
        return buildItemResponse(forgotPasswordService.checkToken(request.getToken()));
    }

    @PostMapping("change-password")
    public ResponseEntity<?> changerPassword(@Valid @RequestBody ForgotPasswordRequest request) {
        forgotPasswordService.changePassword(request);
        String message = "Đổi mật khẩu thành công";
        return buildItemResponse(message);
    }
}
