package uz.javlon.webapp.client.ui.upload.views;

import com.github.gwtbootstrap.client.ui.Form.SubmitCompleteHandler;
import com.github.gwtbootstrap.client.ui.Form.SubmitHandler;
import com.google.gwt.editor.client.EditorDriver;
import com.google.gwt.user.client.ui.IsWidget;
import uz.javlon.webapp.client.ui.upload.FileUploadBean;

import java.util.List;

public interface FileUploadView extends IsWidget {

    public interface Delegate extends SubmitHandler, SubmitCompleteHandler {
        void onCancelClick();
    }

    void setDelegate(Delegate delegate);

    void edit(FileUploadBean fileUpload);

    EditorDriver<FileUploadBean> getEditorDriver();

    void showErrorsMessages(List<String> errors);
}