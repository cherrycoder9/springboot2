package example.day12;

public class Member {
    int memberId;
    String memberName;

    public Member(final int memberId, final String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }

    @Override
    public int hashCode() {
        return memberId;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof final Member member) {
            return this.memberId == member.memberId;
        } else {
            return false;
        }
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(final int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(final String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                '}';
    }
}
