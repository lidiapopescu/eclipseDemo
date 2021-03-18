package com.eclipse.demo.lidia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.text.templates.TemplatePersistenceData;
//import org.eclipse.ui.editors.text.templates.Template;

public class CheckHandler implements IHandler {

	private static final String TEMPLATES_EXTENSION_POINT= "org.eclipse.ui.editors.templates"; //$NON-NLS-1$

	private static final String ID= "id"; //$NON-NLS-1$
	private static final String NAME= "name"; //$NON-NLS-1$

	private static final String CONTEXT_TYPE_ID= "contextTypeId"; //$NON-NLS-1$
	private static final String DESCRIPTION= "description"; //$NON-NLS-1$
	private static final String AUTO_INSERT= "autoinsert"; //$NON-NLS-1$

	private static final String TEMPLATE= "template"; //$NON-NLS-1$
	private static final String PATTERN= "pattern"; //$NON-NLS-1$

	private static final String INCLUDE= "include"; //$NON-NLS-1$
	private static final String FILE= "file"; //$NON-NLS-1$
	private static final String TRANSLATIONS= "translations"; //$NON-NLS-1$

	
	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IConfigurationElement[] extensions = getTemplateExtensions();
//		for (TemplatePersistenceData data : readContributedTemplates(extensions)) {
//			System.out.println(" "+ data.getTemplate().getName() +  " " + data.getTemplate().getContextTypeId());
//		}
		return null;
	}
	
	private Collection<TemplatePersistenceData> readContributedTemplates(IConfigurationElement[] extensions) {
		Collection<TemplatePersistenceData> templates= new ArrayList<>();
		for (IConfigurationElement extension : extensions) {
			if (extension.getName().equals(TEMPLATE)) {
//				createTemplate(templates, extension);
//				System.out.println("Create  TEMPLATE" + extension.getName() + " "+ extension.getValue() +" "+ extension.getNamespace() + " "+ extension.getNamespaceIdentifier());
			} else if (extension.getName().equals(INCLUDE)) {
//				System.out.println("INCLUDE in template "+ extension );
//				readIncludedTemplates(templates, extension);
				if ( extension.getNamespace().equals("org.eclipse.cdt.ui") || extension.getNamespace().equals("com.eclipse.demo.lidia")  ) {
					System.out.println("INCLUDE in template "+ extension.getNamespace() );
//					Activator.log("INCLUDE in template " + extension.getNamespace());
				}
			}
		}
		return templates;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {

	}
	
	
	private static IConfigurationElement[] getTemplateExtensions() {
		return Platform.getExtensionRegistry().getConfigurationElementsFor(TEMPLATES_EXTENSION_POINT);
	}

}
