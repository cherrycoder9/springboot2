package web.model.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import web.model.dto.MemberDto;

@Slf4j
@Component
public class MemberDao extends Dao {
    // 회원가입 dao
    public boolean mSignup(final MemberDto mDto) {
        System.out.println("MemberDao.mSignup");
        try {
            final String sql = "insert into member(id, pw, name, email, phone) values(?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, mDto.getId());
            ps.setString(2, mDto.getPw());
            ps.setString(3, mDto.getName());
            ps.setString(4, mDto.getEmail());
            ps.setString(5, mDto.getPhone());
            ps.executeUpdate();
            return true;
        } catch (final Exception e) {
            log.error("e: ", e);
        } // try end
        return false;
    } // mSignup end

    // 로그인 dao : 로그인 성공한 회원번호 반환(세션에 저장하려고)
    public int mLogin(final MemberDto mDto) {
        System.out.println("MemberDao.mLogin");
        try {
            final String sql = "select * from member where id = ? and pw = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, mDto.getId());
            ps.setString(2, mDto.getPw());
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("no");
            }
        } catch (final Exception e) {
            System.out.println(e);
        } // try end
        return 0; // 못찾음
    }

    // 내정보 화면에 전송할 dao
    public MemberDto mMyinfo(final int no) {
        System.out.println("MemberDao.mMyinfo");
        try {
            final String sql = "select * from member where no = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, no);
            rs = ps.executeQuery();
            if (rs.next()) {
                final MemberDto mDto = new MemberDto();
                mDto.setNo(rs.getInt("no"));
                mDto.setId(rs.getString("id"));
                mDto.setName(rs.getString("name"));
                mDto.setEmail(rs.getString("email"));
                mDto.setPhone(rs.getString("phone"));
                System.out.println(mDto);
                return mDto;
            }
        } catch (final Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // 아이디 찾기 dao
    public String mFindid(final MemberDto mDto) {
        System.out.println("MemberDao.mFindid");
        try {
            final String sql = "select id from member where name = ? and phone = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, mDto.getName());
            ps.setString(2, mDto.getPhone());
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("id");
            }
        } catch (final Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // 비밀번호 찾기 dao
    public String mFindpw(final MemberDto mDto) {
        System.out.println("MemberDao.mFindpw");
        try {
            final String sql = "select pw from member where id = ? and phone = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, mDto.getId());
            ps.setString(2, mDto.getPhone());
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("pw");
            }
        } catch (final Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // 아이디 중복검사 dao
    public boolean mIdCheck(final String id) {
        System.out.println("MemberDao.mIdCheck");
        try {
            final String sql = "select * from member where id =?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            return !rs.next();
        } catch (final Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // 회원정보 수정 dao
    public boolean mModify(final MemberDto mDto) {
        System.out.println("MemberDao.mModify");
        try {
            final String sql = "update member set name =?, pw =?, phone =? where no =?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, mDto.getName());
            ps.setString(2, mDto.getPw());
            ps.setString(3, mDto.getPhone());
            ps.setInt(4, mDto.getNo());
            return ps.executeUpdate() == 1;
        } catch (final Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // 회원 탈퇴 dao
    public boolean mWithdraw(MemberDto mDto) {
        System.out.println("MemberDao.mWithdraw");
        try {
            // 비밀번호와 회원번호 검증 후 맞으면 회원탈퇴 성공 처리
            final String sql = "select * from member where no =? and pw =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mDto.getNo());
            ps.setString(2, mDto.getPw());

            rs = ps.executeQuery();

            if (rs.next()) {
                final String sql2 = "delete from member where no =?";
                ps = conn.prepareStatement(sql2);
                ps.setInt(1, mDto.getNo());
                return ps.executeUpdate() == 1;
            }

        } catch (final Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
