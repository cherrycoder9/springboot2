package web.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.MemberDto;
import web.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService mService;

    // 회원가입 api
    @PostMapping("/signup")
    public boolean mSignup(
            @RequestParam("id") final String id,
            @RequestParam("pw") final String pw,
            @RequestParam("name") final String name,
            @RequestParam("email") final String email,
            @RequestParam("phone") final String phone
    ) {
        System.out.println("MemberController.mSignup");
        final MemberDto mDto = new MemberDto();
        mDto.setId(id);
        mDto.setPw(pw);
        mDto.setName(name);
        mDto.setEmail(email);
        mDto.setPhone(phone);
        System.out.println("mDto = " + mDto);
        return mService.mSignup(mDto);
    }

    // 로그인 api
    @PostMapping("/login")
    public boolean mLogin(
            @RequestParam("id") final String id,
            @RequestParam("pw") final String pw
    ) {
        System.out.println("MemberController.mLogin");
        final MemberDto mDto = new MemberDto();
        mDto.setId(id);
        mDto.setPw(pw);
        System.out.println("mDto = " + mDto);
        return mService.mLogin(mDto);
    }

    // 로그인 체크
    @GetMapping("/login/check")
    public MemberDto mLoginCheck() {
        System.out.println("MemberController.mLoginCheck");
        return mService.mLoginCheck();
    }

    // 로그아웃
    @GetMapping("/logout")
    public void mLogout() {
        mService.mLogout();
    }

    // 아이디 찾기 api
    @PostMapping("/findid")
    public String mFindid(
            @RequestParam("name") final String name,
            @RequestParam("phone") final String phone
    ) {
        System.out.println("MemberController.mFindid");
        final MemberDto mDto = new MemberDto();
        mDto.setName(name);
        mDto.setPhone(phone);
        System.out.println("mDto = " + mDto);
        return mService.mFindid(mDto);
    }

    // 비밀번호 찾기 api
    @PostMapping("/findpw")
    public String mFindpw(
            @RequestParam("id") final String id,
            @RequestParam("phone") final String phone) {
        System.out.println("MemberController.mFindpw");
        final MemberDto mDto = new MemberDto();
        mDto.setId(id);
        mDto.setPhone(phone);
        System.out.println("mDto = " + mDto);
        return mService.mFindpw(mDto);
    }

    // 내정보 화면 출력 api
    @GetMapping("/myinfo")
    public MemberDto mMyinfo() {
        System.out.println("MemberController.mMyinfo");
        return mService.mMyinfo();
    }

    // 아이디 중복검사 api
    @GetMapping("/idcheck")
    public boolean mIdCheck(@RequestParam("id") final String id) {
        System.out.println("MemberController.mIdCheck");
        return mService.mIdCheck(id);
    }

    // 회원정보 수정 api
    @PutMapping("/modify")
    public boolean mModify(
            @RequestParam("name") final String name,
            @RequestParam("pw") final String pw,
            @RequestParam("phone") final String phone
    ) {
        System.out.println("MemberController.mModify");
        final MemberDto mDto = new MemberDto();
        mDto.setName(name);
        mDto.setPw(pw);
        mDto.setPhone(phone);
        System.out.println("mDto = " + mDto);
        return mService.mModify(mDto);
    }

    // 회원탈퇴 api, 비밀번호를 입력받아 검증함
    @DeleteMapping("/withdraw")
    public boolean mWithdraw(@RequestParam("pw") final String pw) {
        System.out.println("MemberController.mWithdrawal");
        return mService.mWithdraw(pw);
    }
}
