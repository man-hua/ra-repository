import com.common.Context
import com.external.PlaceholderService

def res = Context.get(PlaceholderService)
                 .createPost('Automation Test')

assert res.statusCode == 201
