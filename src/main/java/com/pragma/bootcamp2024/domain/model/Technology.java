package com.pragma.bootcamp2024.domain.model;

import com.pragma.bootcamp2024.domain.exception.EmptyFieldException;
import com.pragma.bootcamp2024.domain.exception.StringOutOfBoundsException;
import com.pragma.bootcamp2024.util.DomainConstans;
import static java.util.Objects.requireNonNull;

public class Technology
{
    private final Long idTechnology;
    private final String nameTechnology;
    private final String descriptionTechnology;

    public Technology(long idTechnology, String nameTechnology, String descriptionTechnology)
    {
        this.idTechnology = idTechnology;

        if (nameTechnology.trim().isEmpty())
        {
            throw new EmptyFieldException(DomainConstans.Field.NAME.toString());
        } else if (nameTechnology.length() > 50)
        {
            this.nameTechnology = requireNonNull(nameTechnology, DomainConstans.FIELD_NAME_NULL_MESSAGE);
            throw new StringOutOfBoundsException(DomainConstans.Field.NAMEMAX.toString());
        } else
        {
            this.nameTechnology = requireNonNull(nameTechnology, DomainConstans.FIELD_NAMEMAX_OUT_OF_BOUNDS_MESSAGE);
        }

        if (descriptionTechnology.trim().isEmpty())
        {
            throw new EmptyFieldException(DomainConstans.Field.DESCRIPTION.toString());
        } else if (descriptionTechnology.length() > 90)
        {
            this.descriptionTechnology = requireNonNull(descriptionTechnology, DomainConstans.FIELD_DESCRIPTION_NULL_MESSAGE);
            throw new StringOutOfBoundsException(DomainConstans.Field.DESCRIPTIONMAX.toString());
        } else
        {
            this.descriptionTechnology = requireNonNull(descriptionTechnology, DomainConstans.FIELD_DESCRIPTIONMAX_OUT_OF_BOUNDS_MESSAGE);
        }
    }

    public Long getIdTechnology()
    {
        return idTechnology;
    }
    public String getNameTechnology()
    {
        return nameTechnology;
    }
    public String getDescriptionTechnology()
    {
        return descriptionTechnology;
    }
}
