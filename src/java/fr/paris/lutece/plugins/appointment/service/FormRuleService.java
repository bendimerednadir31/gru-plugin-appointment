package fr.paris.lutece.plugins.appointment.service;

import fr.paris.lutece.plugins.appointment.business.AppointmentFormDTO;
import fr.paris.lutece.plugins.appointment.business.rule.FormRule;
import fr.paris.lutece.plugins.appointment.business.rule.FormRuleHome;

public class FormRuleService {

	/**
	 * 
	 * @param formRule
	 * @param appointmentForm
	 * @param nIdForm
	 */
	public static void fillInFormRule(FormRule formRule, AppointmentFormDTO appointmentForm, int nIdForm) {
		formRule.setIsCaptchaEnabled(appointmentForm.getEnableCaptcha());
		formRule.setIsMandatoryEmailEnabled(appointmentForm.getEnableMandatoryEmail());
		formRule.setIdForm(nIdForm);
	}

	/**
	 * 
	 * @param appointmentForm
	 * @param nIdForm
	 * @return
	 */
	public static FormRule createFormRule(AppointmentFormDTO appointmentForm, int nIdForm) {
		FormRule formRule = new FormRule();
		fillInFormRule(formRule, appointmentForm, nIdForm);
		FormRuleHome.create(formRule);
		return formRule;
	}

	/**
	 * 
	 * @param appointmentForm
	 * @param nIdForm
	 * @return
	 */
	public static FormRule updateFormRule(AppointmentFormDTO appointmentForm, int nIdForm) {
		FormRule formRule = FormRuleService.findFormRuleWithFormId(nIdForm);
		fillInFormRule(formRule, appointmentForm, nIdForm);
		FormRuleHome.update(formRule);
		return formRule;
	}

	/**
	 * 
	 * @param nIdForm
	 * @return
	 */
	public static FormRule findFormRuleWithFormId(int nIdForm) {
		return FormRuleHome.findByIdForm(nIdForm);
	}

}
