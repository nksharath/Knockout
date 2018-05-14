package knockout.core;

import com.knockout.data.RowData;

import java.util.ArrayList;
import java.util.List;

public class KnockoutLogic
{
    public List<RowData> calculateKnockout(final List<RowData> data)
    {
        List<RowData> unTalliedData = new ArrayList<RowData>();

        for (final RowData currentData : data)
        {
            final String currentAmount = currentData.getAmount();
            final String currentIdentifier = currentData.getIdentfier();
            boolean matchFound = false;
            for (final RowData currentDataInner : data)
            {
                if (currentData == currentDataInner)
                {
                    continue;
                }

                final String currentAmountInner = currentDataInner.getAmount();
                final String currentIdentifierInner = currentDataInner.getIdentfier();

                if (currentAmount.equals(currentAmountInner) && !currentIdentifier.equals(currentIdentifierInner))
                {
                    matchFound = true;
                    break;
                }
            }
            if (!matchFound)
            {
                unTalliedData.add(currentData);
            }
        }
        return unTalliedData;
    }
}
