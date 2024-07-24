package web.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

@Service
public class MemberService {
    @Autowired
    MemberDao mDao;
    @Autowired // 현재 요청을 보낸 클라이언트의 HTTP 요청 정보를 가지고 있는 객체를 주입
    HttpServletRequest request;

    // 회원가입 service
    public boolean mSignup(final MemberDto mDto) {
        System.out.println("MemberService.mSignup");
        return mDao.mSignup(mDto);
    }

    // 로그인 service
    public boolean mLogin(final MemberDto mDto) {
        System.out.println("MemberService.mLogin");
        final int result = mDao.mLogin(mDto);
        // 만약 로그인 성공하면
        if (result >= 1) {
            // 빌더패턴: 생성자가 아닌 메소드를 이용한 방식의 객체 생성
            final MemberDto loginDto = MemberDto.builder()
                    .no(result)
                    .id(mDto.getId())
                    .build();
            // HTTP 세션 처리
            // 1. 현재 요청을 보내온 클라이언트의 세션 객체 호출
            final HttpSession session = request.getSession();
            // 2. 세션객체에 속성 추가
            session.setAttribute("loginDto", loginDto);
            // 3. 쿠키 설정 추가 생략
            return true;
        }
        return false;
    }

    // 로그인 상태를 반환하는 service
    public MemberDto mLoginCheck() {
        System.out.println("MemberService.mLoginCheck");
        final HttpSession session = request.getSession();
        final Object object = session.getAttribute("loginDto");
        if (object != null) {
            return (MemberDto) object;
        }
        return null;
    }

    // 로그아웃: 세션 초기화 service
    public void mLogout() {
        System.out.println("MemberService.mLogout");
        // 1. 현재 요청을 보내온 클라이언트의 세션객체 호출
        final HttpSession session = request.getSession();
        System.out.println("로그아웃: " + session.getAttribute("loginDto"));
        // 2. 세션 객체내 모든 속성 값 초기화
        session.invalidate();
    }

    // 아이디 찾기 service
    public String mFindid(final MemberDto mDto) {
        System.out.println("MemberService.mFindid");
        return mDao.mFindid(mDto);
    }


    // 비밀번호 찾기 service
    public String mFindpw(final MemberDto mDto) {
        System.out.println("MemberService.mFindpw");
        return mDao.mFindpw(mDto);
    }

    // 내정보 화면 service
    public MemberDto mMyinfo() {
        System.out.println("MemberService.mInfo");
        // 빌더패턴: 생성자가 아닌 메소드를 이용한 방식의 객체 생성
        final MemberDto loginDto = mLoginCheck();
        if (loginDto == null) {
            return null;
        } else {
            return mDao.mMyinfo(loginDto.getNo());
        }
    }

    // 아이디 중복검사 service
    public boolean mIdCheck(final String id) {
        System.out.println("MemberService.mIdCheck");
        return mDao.mIdCheck(id);
    }

    // 회원정보 수정 service
    public boolean mModify(final MemberDto mDto) {
        System.out.println("MemberService.mModify");
        // 현재 로그인해 있는 회원의 세션정보에 있는 회원번호(no)도 같이 dao로 넘긴다.
        final MemberDto loginDto = mLoginCheck();
        if (loginDto == null) {
            return false;
        } else {
            mDto.setNo(loginDto.getNo());
            return mDao.mModify(mDto);
        }
    }

    // 회원탈퇴 service, 전달받은 pw와 로그인해 있는 세션 회원번호 (no)를 확인후 dao 넘김
    public boolean mWithdraw(final String pw) {
        System.out.println("MemberService.mWithdraw");
        final MemberDto loginDto = mLoginCheck();
        if (loginDto == null) {
            return false;
        } else {
            // 비밀번호와 세션no를 mDto에 저장
            loginDto.setPw(pw);
            loginDto.setNo(loginDto.getNo());
            if (mDao.mWithdraw(loginDto)) {
                // 세션 초기화, 로그아웃 처리
                mLogout();
                return true;
            }
            return false;
        }
    }
}
