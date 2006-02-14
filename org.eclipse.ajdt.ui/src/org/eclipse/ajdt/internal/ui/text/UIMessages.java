/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Ben Dalziel     - initial version
 *******************************************************************************/
package org.eclipse.ajdt.internal.ui.text;

import org.eclipse.osgi.util.NLS;

/**
 * Helper class to get NLSed messages.
 */
public class UIMessages extends NLS {

	private static final String BUNDLE_NAME= UIMessages.class.getName();

	private UIMessages() {
		// Do not instantiate
	}
	
	public static String ajde_version;	
	public static String buildPrereqsMessage;	
	public static String Builder_migration_build;	
	public static String Builder_migration_title;
	public static String Builder_migration_message;
	public static String Builder_migration_toggle;	
	public static String Builder_migration_failed_title;
	public static String Builder_migration_failed_message;	
	public static String ajCompilation;	
	public static String codeTemplates_couldNotLoad;
	public static String ajWarningDialogTitle;
	public static String ajErrorDialogTitle;	
	public static String ajErrorText;
	public static String ajdtErrorDialogTitle;
	public static String jmCoreException;	
	public static String newConfig;	
	public static String BuildConfig_createLstFile;
	public static String BuildConfig_createLstDesc;	
	public static String BuildConfig_openForEdit;
	public static String BuildConfig_activate;
	public static String BuildConfig_newBCFile;	
	public static String BuildConfig_needToSelectProject;
	public static String NewAspectjProjectCreationWizard_title;	
	public static String NewAspectjProjectCreationWizard_op_error_title;
	public static String NewAspectjProjectCreationWizard_op_error_message;
	public static String NewAspectjProjectCreationWizard_MainPage_project_exists_capitalization;
	public static String EditorRulerContextMenu_relatedLocations;
	public static String EditorRulerContextMenu_relatedLocation_message;	
	public static String PluginImportDialog_importConfirmTitle;
	public static String PluginImportDialog_importConfirmMsg;
	public static String PluginImportDialog_importConfirmToggleMsg ;	
	public static String NoAutoPluginImportDialog_title;
	public static String NoAutoPluginImportDialog_message;	
	public static String AutoPluginImportDialog_noEditor_title;
	public static String AutoPluginImportDialog_noEditor_message;
	public static String AutoPluginRemoveDialog_noEditor_title;
	public static String AutoPluginRemoveDialog_noEditor_message;
	public static String AutoPluginRemoveErrorDialog_title;
	public static String AutoPluginRemoveErrorDialog_message;
	public static String PluginImportDialog_removeImportConfirmTitle;
	public static String PluginImportDialog_removeImportConfirmMsg;
	public static String PluginImportDialog_removeImportConfirmToggleMsg;	
	public static String NewAspectJProject_CreateAnAspectJProject;
	public static String NewAspectJProject_CreateAnAspectJProjectDescription;
	public static String NewAspectJProject_BuildSettings;
	public static String NewAspectJProject_BuildSettingsDescription;
	public static String NewTypeWizardPage_SuperClassDialog_title;
	public static String NewTypeWizardPage_SuperClassDialog_message;	
	public static String PluginExportWizard_31Title;
	public static String MultipleOutputDirs_title;
	public static String MultipleOutputDirs_message;	
	public static String NewAspectCreationWizard_title;
	public static String NewAspectCreationWizardPage_title;
	public static String NewAspectCreationWizardPage_description;
	public static String NewAspectCreationWizardPage_supertype_label;	
	public static String NewAspectCreationWizardPage_instantiation_label;
	public static String NewAspectCreationWizardPage_stubs_label;
	public static String NewAspectCreationWizardPage_pointcuts_inherited;
	public static String NewAspectCreationWizardPage_must_be_AJ_project;
	public static String BuildConfigurator_workbench_openXRefView;
	public static String BuildConfigurator_ErrorOpeningXRefView;
	public static String ajEditor;
	public static String AspectJEditor_runtimetest;
	public static String AspectJMarkersAtLine;
	public static String compilerPropsPage_description;
	public static String compilerPropsPage_nonStandardOptions;
	public static String compilerPropsPage_outputJar;
	public static String aspectjPreferences_description;
	public static String aspectjPreferences_compilerVersion;
	public static String aspectjPreferences_pluginVersion;
	public static String aspectjPreferences_adviceDec;
	public static String CompilerConfigurationBlock_error;
	public static String CompilerConfigurationBlock_warning;
	public static String CompilerConfigurationBlock_ignore;
	public static String CompilerConfigurationBlock_needsbuild_title;
	public static String CompilerConfigurationBlock_needsfullbuild_message;
	public static String CompilerConfigurationBlock_needsprojectbuild_message;
	public static String OptionsConfigurationBlock_builderror_message;
	public static String OptionsConfigurationBlock_buildall_taskname;
	public static String OptionsConfigurationBlock_buildproject_taskname;
	public static String CompilerPropertyPage_useworkspacesettings_label;
	public static String CompilerPropertyPage_useworkspacesettings_change;
	public static String CompilerPropertyPage_useprojectsettings_label;
	public static String CompilerConfigurationBlock_aj_messages_tabtitle;
	public static String CompilerConfigurationBlock_aj_messages_description;
	public static String CompilerConfigurationBlock_aj_invalid_absolute_type_name_label;
	public static String CompilerConfigurationBlock_aj_invalid_wildcard_type_name_label;
	public static String CompilerConfigurationBlock_aj_unresolvable_member_label;
	public static String CompilerConfigurationBlock_aj_type_not_exposed_to_weaver_label;
	public static String CompilerConfigurationBlock_aj_shadow_not_in_structure_label;
	public static String CompilerConfigurationBlock_aj_unmatched_super_type_in_call_label;
	public static String CompilerConfigurationBlock_aj_cannot_implement_lazy_tjp_label;
	public static String CompilerConfigurationBlock_aj_need_serial_version_uid_field_label;
	public static String CompilerConfigurationBlock_aj_incompatible_serial_version_label;
	public static String CompilerConfigurationBlock_aj_no_interface_ctor_joinpoint_label;
	public static String CompilerConfigurationBlock_aj_advanced_tabtitle;
	public static String CompilerConfigurationBlock_aj_advanced_description;
	public static String CompilerConfigurationBlock_aj_no_weave_label;
	public static String CompilerConfigurationBlock_aj_x_serializable_aspects_label;
	public static String CompilerConfigurationBlock_aj_x_no_inline_label;
	public static String CompilerConfigurationBlock_aj_x_not_reweavable_label;
	public static String CompilerConfigurationBlock_aj_x_has_member_label;
	public static String CompilerConfigurationBlock_aj_other_tabtitle;
	public static String CompilerConfigurationBlock_aj_other_description;
	public static String CompilerConfigurationBlock_aj_enable_incremental_label;
	public static String CompilerConfigurationBlock_aj_enable_build_asm_label;
	public static String CompilerConfigurationBlock_aj_enable_weave_messages_label;
	public static String CompilerConfigurationBlock_aj_5_description;
	public static String CompilerConfigurationBlock_aj_5_tabtitle;
	public static String CompilerConfigurationBlock_noJoinpointsForBridgeMethods;
	public static String CompilerConfigurationBlock_cantMatchArrayTypeOnVarargs;
	public static String CompilerConfigurationBlock_enumAsTargetForDecpIgnored;
	public static String CompilerConfigurationBlock_annotationAsTargetForDecpIgnored;
	public static String CompilerConfigurationBlock_invalidTargetForAnnotation;
	public static String CompilerConfigurationBlock_elementAlreadyAnnotated;
	public static String CompilerConfigurationBlock_adviceDidNotMatch;
	public static String CompilerConfigurationBlock_runtimeExceptionNotSoftened;
	public static String CompilerConfigurationBlock_unmatchedTargetKind;
	public static String CompilerConfigurationBlock_uncheckedArgument;
	public static String CompilerConfigurationBlock_uncheckedAdviceConversion;
	public static String CompilerConfigurationBlock_unordered_advice_at_shadow;
	public static String CompilerConfigurationBlock_aspect_excluded_by_configuration;
	public static String CompilerConfigurationBlock_no_explicit_constructor_call;
	public static String CompilerConfigurationBlock_no_guard_for_lazy_tjp;
	public static String CompilerConfigurationBlock_multiple_advice_stopping_lazy_tjp;
	public static String InPathBlock_tab_inpath_order;
	public static String InPathBlock_tab_libraries;
	public static String InPathBlock_order_up_button;
	public static String InPathBlock_order_down_button;
	public static String AspectPathBlock_tab_libraries;
	public static String InPathLibrariesWorkbookPage_NewClassFolderDialog_new_title;
	public static String InPathLibrariesWorkbookPage_NewClassFolderDialog_edit_title;
	public static String InPathLibrariesWorkbookPage_NewClassFolderDialog_description;
	public static String InPathLibrariesWorkbookPage_configurecontainer_error_title;
	public static String InPathLibrariesWorkbookPage_configurecontainer_error_message;
	public static String InPathLibrariesWorkbookPage_exclusion_added_title;
	public static String InPathLibrariesWorkbookPage_exclusion_added_message;
	public static String InPathLibrariesWorkbookPage_libraries_inpath_label;
	public static String InPathLibrariesWorkbookPage_libraries_addjar_button;
	public static String InPathLibrariesWorkbookPage_libraries_addextjar_button;
	public static String InPathLibrariesWorkbookPage_libraries_addvariable_button;
	public static String InPathLibrariesWorkbookPage_libraries_addlibrary_button;//250
	public static String InPathLibrariesWorkbookPage_libraries_addclassfolder_button;
	public static String InPathLibrariesWorkbookPage_libraries_edit_button;
	public static String InPathLibrariesWorkbookPage_libraries_remove_button;
	public static String AspectPathLibrariesWorkbookPage_libraries_edit_button;
	public static String AspectPathLibrariesWorkbookPage_libraries_remove_button;
	public static String AspectPathLibrariesWorkbookPage_libraries_aspectpath_label;
	public static String AspectPathLibrariesWorkbookPage_libraries_addjar_button;
	public static String AspectPathLibrariesWorkbookPage_libraries_addextjar_button;
	public static String AspectPathLibrariesWorkbookPage_libraries_addvariable_button;
	public static String AspectPathLibrariesWorkbookPage_libraries_addlibrary_button;
	public static String AspectPathLibrariesWorkbookPage_libraries_addclassfolder_button;
	public static String AspectPathLibrariesWorkbookPage_NewClassFolderDialog_description;
	public static String AspectPathLibrariesWorkbookPage_configurecontainer_error_title;
	public static String AspectPathLibrariesWorkbookPage_configurecontainer_error_message;
	public static String AspectPathLibrariesWorkbookPage_exclusion_added_message;
	public static String InPathBlock_operationdesc_java;
	public static String InPathBlock_warning_EntryMissing;
	public static String InPathBlock_warning_EntriesMissing;
	public static String InPathBlock_inpath_label;
	public static String InPathBlock_inpath_checkall_button;
	public static String InPathBlock_inpath_uncheckall_button;
	public static String AspectPathBlock_aspectpath_label;
	public static String AspectPathBlock_warning_EntryMissing;
	public static String AspectBlock_warning_EntriesMissing;
	public static String AspectPathBlock_operationdesc_java;
	public static String InPathProp_exceptionInitializingInpath_title;
	public static String InPathProp_exceptionInitializingInpath_message;
	public static String AspectPathProp_exceptionInitializingAspectpath_title;
	public static String AspectPathProp_exceptionInitializingAspectpath_message;
	public static String Path_entryNotFound_warningTitle;
	public static String Path_entryNotFound_warningMessage;
	public static String BuildPage_name;
	public static String AJPropsEditor_BuildPage_title ;
	public static String AJPropsEditor_SrcSection_title ;
	public static String AJPropsEditor_SrcSection_desc ;
	public static String buildConfig_exceptionIncluding;
	public static String buildConfig_exceptionException;
	public static String buildConfig_exceptionWriting ;
	public static String buildConfig_notFound;
	public static String buildConfig_standardFileName; 
	public static String BCDialog_Overwrite_title ;
	public static String BCDialog_Overwrite_message ;
	public static String BCDialog_Overwrite_yes ;
	public static String BCDialog_Overwrite_no ;
	public static String BCDialog_SaveLstAsAJProp_title ;
	public static String BCDialog_SaveLstAsAJProp_message ;
	public static String BCDialog_SaveAJPropAsLst_title ;
	public static String BCDialog_SaveAJPropAsLst_message ;
	public static String BCDialog_SaveBuildConfigurationAs_title ;
	public static String BCDialog_SaveBuildConfigurationAs_message ;
	public static String BCDialog_SaveBuildConfigurationAs_default;
	public static String BCDialog_NameValidator_ExistsError;
	public static String BCLabels_SaveBCAs;
	public static String BCLabels_ConfigurationSelectionMenu;
	public static String BCLabels_IncludeAction;
	public static String BCLabels_ExcludeAction;
	public static String ajdocWizard_javadocwizard_title;
	public static String ajdocWizard_ajdocprocess_label;
	public static String ajdocWizardPage_javadocwizardpage_description;
	public static String ajdocTreeWizardPage_visibilitygroup_label;
	public static String ajdocTreeWizardPage_privatevisibilitydescription_label;
	public static String ajdocTreeWizardPage_packagevisibledescription_label;
	public static String ajdocTreeWizardPage_protectedvisibilitydescription_label;
	public static String ajdocTreeWizardPage_publicvisibilitydescription_label;
	public static String ajdocTreeWizardPage_javadoctreewizardpage_description;
	public static String ajdocTreeWizardPage_warning_mayoverwritefiles;
	public static String ajdocTreeWizardPage_ajdoccommand_label;
	public static String ajdocTreeWizardPage_ajdoccmd_error_enterpath;
	public static String ajdocTreeWizardPage_ajdoccmd_error_notexists;
	public static String AJdocTreeWizardPage_ajdoccmd_dialog_title;
	public static String ajdocSpecificsWizardPage_description;
	public static String ajdocSpecificsWizardPage_vmoptionsfield_label;
	public static String ajdoc_error_noProjectSelected;
	public static String ajdoc_info_projectselection;
	public static String ajdocWizard_error_title;
	public static String ajdocWizard_error_cant_find_ajde_jar;
	public static String ajdocWizard_error_cant_find_weaver_jar;
	public static String ajdocWizard_error_cant_find_runtime_jar;
	public static String ajdocWizard_launch_error_message;
	public static String ajdocWizard_exec_error_message;
	public static String myEclipse_natureDetected_title;
	public static String myEclipse_natureDetected_message;
	public static String AspectJWarning;
	public static String AspectJError;
	public static String ResetColorMemory;
	public static String HideErrors;
	public static String HideWarnings;
	public static String Launcher_aspectPath;
	public static String Launcher_outJar;
	public static String FileFilterDialog_JobTitle;
	public static String FileFilterDialog_Title;
	public static String FileFilterDialog_Message;
	public static String FileFilterDialog_CheckboxCaption;
	public static String codeAssist_limited_title;
	public static String codeAssist_limited_message;
	public static String Refactoring_ErrorRenamingResource;
	public static String Refactoring_ConvertAllToJava;
	public static String Refactoring_ConvertAllToAJ;
	public static String Refactoring_ConvertAspectsToAJAndClassesToJava;
	public static String Refactoring_IncludeFilesNotInBuild;
	public static String Refactoring_UpdateBuildConfigs;
	public static String Refactoring_ConvertFileExtensions;
	public static String Refactoring_ConvertingFileExtensions;
	public static String utils_refresh_explorer_job;
	public static String utils_refresh_outline_job;
	public static String editor_title_refresh_job;
	public static String wrong_eclipse_version;
	public static String savemap_dialog_title;
	public static String savemap_as_default;
	public static String savemap_dialog_message;
	public static String changesView_table_column1;
	public static String changesView_table_column2;
	public static String changesView_table_column3;
	public static String changesView_table_column4;
	public static String changesView_table_added;
	public static String changesView_table_removed;
	public static String changesView_description;
	public static String changesView_currentBuild;
	public static String ajmapEditor_title;
	public static String ajmapEditor_heading;
	public static String ajmapEditor_description;
	public static String changesView_filter_dialog_title;
	public static String changesView_filter_dialog_message;
	public static String changesView_filter_dialog_showingXofY;
	public static String changesView_filter_action_tooltip; 
	public static String quickFix_ConvertProjectToAspectJ;
	public static String quickFix_OpenInAspectJEditor;
	public static String AJFiles_title;
	public static String AJFiles_message;
	public static String UpdateJob_name;
	public static String buildConfigurationChangeAction_job_name;
	public static String excludeAction_job_name;
	public static String includeAction_job_name;
	public static String dynamicBuildConfigurationMenu_job_name;
	public static String PulldownBuildselectorMenu_no_open_ajproject;
	public static String PulldownBuildselectorMenu_build_error;
	public static String CompilerMonitor_building_Project;
	public static String CompilerMonitor_weaving;
	public static String CompilerTaskListManager_Error_creating_marker;
	public static String CompilerTaskListManager_Error_adding_problem_markers;
	public static String BuildConfigEditor_failed_update;
	public static String BuildConfigEditor_unable_to_go_to_marker;
	public static String BuildConfigEditor_invalid_input;
	public static String AdviceActionDelegate_exception_adding_advice_to_context_menu;
	public static String AdviceActionDelegate_unable_to_create_marker;
	public static String AdviceActionDelegate_exception_jumping;
	public static String AdviceActionDelegate_problem_finding_jump_location;
	public static String AdviceActionDelegate_resource_not_found;
	public static String PointcutNavigatorView_rebuild_to_view_structure;
	public static String PointcutNavigatorView_advises;
	public static String PointcutNavigatorView_pin_structure_model;
	public static String PointcutNavigatorView_pin_structure_model_tooltip;
	public static String AJCompilerPreferencePage_aspectj_compiler;
	public static String AspectJPreferencePage_support_information;
	public static String AspectJPreferencePage_refer_to_forum;
	public static String AspectJPreferencePage_on_the_website;
	public static String AspectJPreferencePage_licensing;
	public static String AspectJPreferencePage_copyright;
	public static String AspectJPreferencePage_copyright2;
	public static String AspectJPreferencePage_copyright3;
	public static String AspectJPreferencePage_copyright4;
	public static String AspectJPreferencePage_copyright5;
	public static String AJXReferenceProvider_description;
	public static String AJDTUtils_project_cannot_be_rebuilt;
	public static String AJDTUtils_cleaning_recommended;
	public static String AJDTUtils_no_message;
	public static String AJDTStructureViewNode_import_declarations;
	public static String AJDTStructureViewNode_matches; 
	public static String AJDTStructureViewNode_runtime_test;
	public static String AspectJUIPlugin_exception_in_selection_changed;
	public static String AspectJUIPlugin_exception_retrieving_lst_files;
	public static String LTWAspectPathTab_errormessage;
	public static String LTWAspectPathTab_label;
	public static String LTWAspectPathTab_title;
	public static String LTW_error_launching;
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, UIMessages.class);
	}

}
