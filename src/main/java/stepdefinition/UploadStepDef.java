package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import utils.UploadUtils;

public class UploadStepDef {

	@Then("^I upload zero byte file ([^\\\"]*) under documents folder and verify the file cannot be uploaded$")
	public void i_upload_zero_byte_file(String filename) throws Throwable {
		UploadUtils.upload(filename, true);

	}

	@Then("^I upload a file ([^\\\"]*) under documents folder and verify the uploaded file$")
	public void i_upload_a_file(String filename) throws Throwable {
		UploadUtils.upload(filename, false);

	}

	@And("^I edit ([^\"]*) and save the uploaded file$")
	public void i_edit_the_uploaded_file(String modifiedFileContent) throws Throwable {
		UploadUtils.editUploadedFileInOneDriveEditor(modifiedFileContent);
	}

	@Then("^I download and compare the different versions of the file with ([^\"]*) from ([^\\\"]*)$")
	public void i_save_the_edited_file(String modifiedFileContent, String fileLoc) throws Throwable {
		UploadUtils.verifyVersionHistory(modifiedFileContent, fileLoc);
	}

	@Then("^I delete the uploaded document$")
	public void i_delete_the_uploaded_file() throws Throwable {
		UploadUtils.deleteFile();

	}

}
