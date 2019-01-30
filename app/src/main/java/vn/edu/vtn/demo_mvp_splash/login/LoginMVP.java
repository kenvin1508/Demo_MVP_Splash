package vn.edu.vtn.demo_mvp_splash.login;

public interface LoginMVP {
    interface View {
        void showResult(boolean result,String username);
    }

    interface Presenter {
        void checkLogin(String username, String password);

    }
}
