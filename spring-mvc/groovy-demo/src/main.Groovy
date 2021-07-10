import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil

def file = PsiDocumentManager.getInstance(_editor.project).getPsiFile(_editor.document);
PsiMethod method = PsiTreeUtil.findElementOfClassAtOffset(file, _editor.caretModel.offset, PsiMethod.class, false);
PsiParameter[] parameters = method == null ? PsiParameter.EMPTY_ARRAY : method.parameterList.parameters;
return parameters.size() == 0 ? '' : '\"' + parameters.collect {
    def prefix = it.name + ' = ';
    def type = it.type;
    return type instanceof PsiArrayType ? type.componentType instanceof PsiPrimitiveType ? prefix + '\" + java.util.Arrays.toString(' + it.name + ')' : prefix + '\" + java.util.Arrays.deepToString(' + it.name + ')' : prefix + '\" + ' + it.name
}.join(' + \", ')