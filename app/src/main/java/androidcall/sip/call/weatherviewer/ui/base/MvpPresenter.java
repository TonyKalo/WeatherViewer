package androidcall.sip.call.weatherviewer.ui.base;

public interface MvpPresenter <V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleErrors(Throwable e);
}
